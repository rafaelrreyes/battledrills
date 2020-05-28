import React from "react";
import PropTypes from "prop-types";
import { useClickOutside } from "HOOKS/index";
import "./MenuDropdown.scss";

const MenuDropdown = ({ menuOptions, closeMenu, className = "" }) => {
	const menuRef = useClickOutside(closeMenu);

	const renderMenuOptions = () => {
		return menuOptions.map((menuOptions, index) => {
			return (
				<div
					key={index}
					onClick={() => {
						// do the defined click method, then close the menu dropdown
						menuOptions.menuAction();
						closeMenu();
					}}
					className="menu-option"
				>
					{menuOptions.icon && <span className="menu-option-icon">{menuOptions.icon}</span>}
					{menuOptions.name}
				</div>
			);
		});
	};

	return (
		<div ref={menuRef} className={`menu-content ${className}`}>
			{renderMenuOptions()}
		</div>
	);
};

MenuDropdown.propTypes = {
	closeMenu: PropTypes.func.isRequired,
	menuOptions: PropTypes.arrayOf(
		PropTypes.shape({
			icon: PropTypes.node,
			name: PropTypes.oneOfType([PropTypes.string, PropTypes.element]).isRequired,
			menuAction: PropTypes.func.isRequired
		})
	).isRequired,
	className: PropTypes.string
};

export default MenuDropdown;
