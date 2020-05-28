import React, { Component } from "react";
import PropTypes from "prop-types";
import "./Tabs.scss";

export class Tabs extends Component {
	constructor(props) {
		super(props);

		this.state = {
			selectedIndex: this.props.selectedIndex,
			selectedName: ""
		};
	}

	componentDidMount() {}

	renderTabs = () => {
		return this.props.children.map((tab, tabIndex) => {
			return React.cloneElement(tab, {
				onClick: this.onTabClicked,
				tabIndex,
				isActive: tabIndex === this.state.selectedIndex
			});
		});
	};

	onTabClicked = ({ selectedIndex, selectedName }) => {
		if (selectedIndex === this.state.selectedIndex) {
			return;
		}

		this.setState({ selectedIndex, selectedName }, () => {
			const { selectedIndex, selectedName } = this.state;
			this.props.onActiveTabSelected({ selectedIndex, selectedName });
		});
	};

	render = () => {
		return (
			<div className="tabs">
				<ul className="tabs-list">{this.renderTabs()}</ul>
			</div>
		);
	};
}

Tabs.propTypes = {
	children: PropTypes.arrayOf(PropTypes.object).isRequired,
	onActiveTabSelected: PropTypes.func.isRequired
};
