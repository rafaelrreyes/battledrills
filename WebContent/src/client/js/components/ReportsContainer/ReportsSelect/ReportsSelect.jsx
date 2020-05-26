import React, { useState } from "react";
import { Dropdown, DropdownSizes, DropdownTypes, DROPDOWN_DEFAULT } from "CORE";
import { Button, ButtonSizes, ButtonTypes } from "CORE";
import { MultiSelect, MultiSelectSizes } from "CORE";
import { ArrowTooltip, TooltipTypes, TooltipPlacement } from "CORE";
import { DrillState } from "UTILITIES";
import "./ReportsSelect.scss";

const DRILL_TYPES = ["Active", "Completed"];
const DEFAULT_SELECT_DRILL = "Select a drill";

export const ReportsSelect = ({ selectedDrillName, allDrills, onGenerateReport }) => {
	const getInitialDrillType = () => {
		if (selectedDrillName !== undefined) {
			const activeDrill = allDrills.active.find((element) => {
				return element === selectedDrillName;
			});

			return activeDrill === undefined ? "Completed" : "Active";
		} else {
			return "Completed";
		}
	};

	const [drillType, setDrillType] = useState(getInitialDrillType);
	const [drill, setDrill] = useState(selectedDrillName ? selectedDrillName : DROPDOWN_DEFAULT);
	const [compareDrills, setCompareDrills] = useState([]);
	const [drillNameError, setDrillNameError] = useState(false);

	const onDrillTypeChange = (type) => {
		setDrillType(type);
		setDrill(DROPDOWN_DEFAULT);
	};

	const onSelectDrill = (selection) => {
		setDrill(selection);
		setDrillNameError(false);
	};

	const onCompareDrillsSelect = (drills) => {
		setCompareDrills(drills);
	};

	const getDrillOptions = () => {
		return drillType === DrillState.ACTIVE ? allDrills.active : allDrills.completed;
	};

	const getCompareOptions = () => {
		if (drillType === DrillState.ACTIVE) {
			return allDrills.active.filter((activeDrill) => {
				return activeDrill !== drill;
			});
		} else {
			return allDrills.completed.filter((completedDrill) => {
				return completedDrill !== drill;
			});
		}
	};

	const onGenerate = () => {
		if (drill === DROPDOWN_DEFAULT) {
			setDrillNameError(true);
		} else {
			onGenerateReport(drill, compareDrills);
		}
	};

	return (
		<>
			<div className="drill-type-dropdown">
				<Dropdown
					dropdownType={DropdownTypes.REGULAR}
					dropdownSize={DropdownSizes.MEDIUM}
					options={DRILL_TYPES}
					onChange={onDrillTypeChange}
					firstOption={"Select a drill type"}
					firstValid={false}
					defaultSelect={drillType}
				/>
			</div>
			<div className="drill-name-dropdown">
				<ArrowTooltip
					title={drillNameError ? "Must select a drill" : ""}
					placement={TooltipPlacement.TOP}
					type={TooltipTypes.ERROR}
					open={true}
				>
					<Dropdown
						dropdownType={DropdownTypes.REGULAR}
						dropdownSize={DropdownSizes.MEDIUM}
						options={getDrillOptions()}
						onChange={onSelectDrill}
						firstOption={DEFAULT_SELECT_DRILL}
						defaultSelect={drill}
						showError={drillNameError}
					/>
				</ArrowTooltip>
			</div>
			<div className="drill-name-dropdown">
				<MultiSelect
					options={getCompareOptions()}
					removeSelected={drill}
					dropdownLabel="Select drills to compare"
					handleSelection={onCompareDrillsSelect}
					size={MultiSelectSizes.MEDIUM}
				/>
			</div>
			<div className="generate-button">
				<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.REGULAR} onClick={onGenerate}>
					Generate
				</Button>
			</div>
		</>
	);
};
