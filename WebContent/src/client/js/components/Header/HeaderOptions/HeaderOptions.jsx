import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { MenuDropdown, ModalContentTypes, openCreateDrillModal, Icon } from "CORE";
import { MaterialIconNames, DrillTypes } from "UTILITIES";
import { showModal } from "REDUX";

const HeaderOptions = ({}) => {
	const [showMenu, setShowMenu] = useState(false);

	const dispatch = useDispatch();

	const menuOptions = [
		{
			name: "Create Drill",
			menuAction: () => {
				openCreateDrillModal(DrillTypes.DEFAULT);
			}
		},
		{
			name: "Create Custom Drill",
			menuAction: () => {
				openCreateDrillModal(DrillTypes.CUSTOM);
			}
		},
		{
			name: "Version",
			menuAction: () => {
				dispatch(
					showModal(ModalContentTypes.VERSION, {
						title: "Version",
						singleButton: true
					})
				);
			}
		}
	];

	const onMenuIconClicked = () => {
		setShowMenu(!showMenu);
	};

	return (
		<div>
			<Icon className="menu-icon" onClick={onMenuIconClicked}>
				{MaterialIconNames.MORE_HORIZONTAL}
			</Icon>
			{showMenu && <MenuDropdown menuOptions={menuOptions} closeMenu={onMenuIconClicked} />}
		</div>
	);
};

export default HeaderOptions;
