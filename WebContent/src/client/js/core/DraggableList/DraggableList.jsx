import React, { Component } from "react";
import PropTypes from "prop-types";
import { MaterialIconNames, isContentOverflowed } from "UTILITIES/index";
import { ArrowTooltip } from "CORE/index";
import "./DraggableList.scss";

class DraggableList extends Component {
	constructor(props) {
		super(props);
		this.draggableItemRefs = {};
		this.setDraggableItemRefs = (element) => {
			if (element) {
				this.draggableItemRefs[element.textContent] = element;
			}
		};
	}

	onItemClick = (e, index) => {
		const { itemClick } = this.props;
		if (itemClick !== undefined) {
			if (typeof this.props.items[index] === "object") {
				itemClick(this.props.items[index].id);
			} else {
				itemClick(this.props.items[index]);
			}
		}
	};

	onDragStart = (e, index) => {
		this.draggedItem = this.props.items[index];
		e.dataTransfer.effectAllowed = "move";
		e.dataTransfer.setData("text/html", e.target.parentNode);
		e.dataTransfer.setDragImage(e.target.parentNode, 20, 20);
	};

	onDragOver = (e, index) => {
		e.preventDefault();
		const { items, viewUpdate } = this.props;
		const draggedOverItem = items[index];
		if (this.draggedItem === draggedOverItem) {
			return;
		}

		let filteredItems = items.filter((item) => item !== this.draggedItem);

		filteredItems.splice(index, 0, this.draggedItem);

		if (typeof viewUpdate === "function" && typeof viewUpdate !== "undefined") {
			viewUpdate(filteredItems);
		}
	};

	onDragEnd = () => {
		const { items, backendUpdate } = this.props;
		// at the end of whatever drag occurs, update the backend storage if a method was
		// passed to do an update
		if (typeof backendUpdate === "function" && typeof backendUpdate !== "undefined") {
			backendUpdate(items);
		}

		this.draggedItem = null;
	};

	renderListElement = (item, index) => {
		const { tooltipPlacement } = this.props;
		let itemLabel = item;

		let tooltip = isContentOverflowed(this.draggableItemRefs[item]) ? item : "";
		if (typeof item === "object") {
			itemLabel = typeof item.name !== "undefined" ? item.name : "item_name_placeholder";
		}

		return (
			<ArrowTooltip title={tooltip} placement={tooltipPlacement}>
				<li className="draggable-li" onClick={(e) => this.onItemClick(e, index)}>
					<div ref={this.setDraggableItemRefs} className="li-text-div">
						{itemLabel ? itemLabel : "item_name_placeholder"}
					</div>
				</li>
			</ArrowTooltip>
		);
	};

	renderList = () => {
		const { items, selectedItem } = this.props;
		return items.map((item, index) => {
			let listClass = "draggable-li-wrapper";

			if (typeof selectedItem === "object") {
				if (selectedItem.id && selectedItem.id === item.id) {
					listClass += " selected-list-item";
				}
			} else {
				if (selectedItem && selectedItem === item) {
					listClass += " selected-list-item";
				}
			}

			return (
				<div className={listClass} key={index}>
					<div>
						<i
							className="material-icons md-18 drag-icon"
							draggable
							onDragStart={(e) => this.onDragStart(e, index)}
							onDragOver={(e) => this.onDragOver(e, index)}
							onDragEnd={this.onDragEnd}
						>
							{MaterialIconNames.SWAP_VERT}
						</i>
						{this.renderListElement(item, index)}
					</div>
				</div>
			);
		});
	};

	render = () => {
		return (
			<div className="draggable-list">
				<ul className="draggable-ul">{this.renderList()}</ul>
			</div>
		);
	};
}

DraggableList.defaultProps = {
	tooltipPlacement: "top"
};

DraggableList.propTypes = {
	items: PropTypes.array.isRequired,
	viewUpdate: PropTypes.func.isRequired,
	backendUpdate: PropTypes.func.isRequired,
	itemClick: PropTypes.func,
	selectedItem: PropTypes.object
};

export default DraggableList;
