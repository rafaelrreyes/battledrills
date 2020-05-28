import React from "react";
import ReactDOM from "react-dom";
import joint from "jointjs/index";
import $ from "jquery";
import _ from "lodash";
import { getTaskItemStyle, getLiElement } from "./BattleDrillHelper";
import { StatusTypes, selectTask, selectTaskTemplate } from "UTILITIES";
import { TaskActionsMenu, OwnerActionsMenu } from "COMPONENTS";

joint.shapes.html = {};

joint.shapes.html.OwnerBlock = joint.shapes.standard.Rectangle.extend({
	defaults: joint.util.deepSupplement(
		{
			type: "html.Owner",
			attrs: {
				rect: { stroke: "none", "fill-opacity": 0 }
			}
		},
		joint.shapes.standard.Rectangle.prototype.defaults
	)
});

joint.shapes.html.OwnerView = joint.dia.ElementView.extend({
	template: ['<div class="owner-container">', '<div><span class="owner-title"></span></div>', "</div>"].join(""),
	initialize: function () {
		joint.dia.ElementView.prototype.initialize.apply(this, arguments);
		this.$box = $(_.template(this.template)());

		this.model.on("change", this.updateBox, this);
		// Remove the box when the model gets removed from the graph.
		this.model.on("remove", this.removeBox, this);
	},
	updateBox: function () {
		var bbox = this.model.getBBox();
		let owner = this.model.get("attrs").title;
		let isTemplate = this.model.get("attrs").diagramData.isTemplate;

		let editIconClass = isTemplate ? "template-edit-owner-icon" : "edit-owner-icon";

		this.$box
			.find("span.owner-title")
			.html(`${owner}<i class="material-icons ${editIconClass}">edit</i><div class="filler-div"></div>`);

		this.$box.find("i").on("click", (event) => {
			const dropdownAlreadyOpen = ReactDOM.unmountComponentAtNode(event.target.nextSibling);
			if (dropdownAlreadyOpen) {
				return;
			}
			ReactDOM.render(
				<OwnerActionsMenu
					isTemplate={isTemplate}
					closeMenu={() => {
						if (typeof event.target !== "undefined") {
							ReactDOM.unmountComponentAtNode(event.target.nextSibling);
						}
					}}
					owner={owner}
				/>,
				event.target.nextSibling
			);
		});
		this.$box.css({
			width: bbox.width,
			left: bbox.x,
			top: bbox.y
		});
	},
	render: function () {
		joint.dia.ElementView.prototype.render.apply(this, arguments);
		this.paper.$el.prepend(this.$box);
		this.updateBox();
		return this;
	},
	removeBox: function (evt) {
		this.$box.remove();
	}
});

joint.shapes.html.ActionBlock = joint.shapes.standard.Rectangle.extend({
	defaults: joint.util.deepSupplement(
		{
			type: "html.Action",
			attrs: {
				rect: { stroke: "none", "fill-opacity": 0 }
			}
		},
		joint.shapes.standard.Rectangle.prototype.defaults
	)
});

joint.shapes.html.ActionView = joint.dia.ElementView.extend({
	template: [
		'<div class="action-items-container">',
		'<div class="draggable-tasks"><i class="material-icons">open_with</i></div>',
		'<ul class="action-items"></ul>',
		"</div>"
	].join(""),

	initialize: function () {
		joint.dia.ElementView.prototype.initialize.apply(this, arguments);
		this.$box = $(_.template(this.template)());

		const isTemplate = this.model.get("attrs").diagramData.isTemplate;
		if (isTemplate) {
			this.$box.find("ul").on(
				"click",
				_.bind((event) => {
					const tasks = this.model.get("attrs").list;
					let taskId = getLiElement(event.target).getAttribute("taskId");

					tasks.forEach((task) => {
						if (task.taskId === taskId) {
							selectTaskTemplate(task);
							return;
						}
					});
				}, this)
			);
		} else {
			this.$box.find("ul").on(
				"click",
				_.bind((event) => {
					const tasks = this.model.get("attrs").list;
					let taskId = getLiElement(event.target).getAttribute("taskId");

					// probably a better way to do this
					// 6 cases where you dont want to select the task based on what's clicked
					if (
						event.target.classList.contains("task-option-icon") ||
						event.target.classList.contains("menu-option") ||
						event.target.classList.contains("menu-option-icon")
					) {
						return;
					} else if (
						event.target.classList.contains("in-progress-icon") ||
						event.target.classList.contains("blocked-icon") ||
						event.target.classList.contains("completed-icon")
					) {
						// need this check to know that the dropdown icon was selected, not the icon in the list/diagram
						if (event.target.parentElement.classList.contains("menu-option-icon")) {
							return;
						}
					}

					// is there a faster way to search for the selected task
					tasks.forEach((task) => {
						if (task.taskId === taskId) {
							selectTask(task);
							return;
						}
					});
				}, this)
			);
		}

		this.model.on("change", this.updateBox, this);
		// Remove the box when the model gets removed from the graph.
		this.model.on("remove", this.removeBox, this);
	},
	render: function () {
		joint.dia.ElementView.prototype.render.apply(this, arguments);
		this.paper.$el.prepend(this.$box);
		this.updateBox();
		return this;
	},
	updateBox: function () {
		var bbox = this.model.getBBox();
		// Example of updating the HTML with a data stored in the cell model.

		// Create action items HTML
		var tasks = this.model.get("attrs").list;
		let selectedTask = this.model.get("attrs").selectedTask;
		const isTemplate = this.model.get("attrs").diagramData.isTemplate;

		var tasksHTML = _.map(tasks, (task) => {
			return getTaskItemStyle(task, selectedTask, isTemplate);
		});

		// not a template, show completed items
		if (!isTemplate) {
			let allTasksCompleted = tasks.filter((task) => task.currentStatus.status !== StatusTypes.COMPLETED);

			if (allTasksCompleted.length === 0) {
				this.$box.find("ul").addClass("all-completed");
			}
		}

		this.$box
			.find("ul")
			.html(tasksHTML)
			.find("li")
			.hover(
				(event) => {
					const liElement = getLiElement(event.target);
					if (liElement.lastChild.firstChild.style) {
						liElement.lastChild.firstChild.style.visibility = "visible";
					}
				},
				(event) => {
					const liElement = getLiElement(event.target);
					// if the dropdown menu is open, don't hide the dropdown icon when leaving the hover
					if (!liElement.querySelector(".menu-content")) {
						if (liElement.lastChild.firstChild.style) {
							liElement.lastChild.firstChild.style.visibility = "hidden";
						}
					}
				}
			);

		this.$box.find("i.task-option-icon").on("click", (event) => {
			const dropdownAlreadyOpen = ReactDOM.unmountComponentAtNode(event.target.nextSibling);
			if (dropdownAlreadyOpen) {
				return;
			}
			ReactDOM.render(
				<TaskActionsMenu
					closeMenu={() => {
						event.target.style.visibility = "hidden";
						ReactDOM.unmountComponentAtNode(event.target.nextSibling);
					}}
					taskId={getLiElement(event.target).getAttribute("taskId")}
				/>,
				event.target.nextSibling
			);
		});

		const resizedHeight = this.$box.find("ul")[0].clientHeight;
		this.model.resize(bbox.width, resizedHeight);
		this.$box.css({
			width: bbox.width,
			left: bbox.x,
			top: bbox.y
			// transform: "rotate(" + (this.model.get("angle") || 15) + "deg)"
		});
	},
	removeBox: function (evt) {
		this.$box.remove();
	}
});
