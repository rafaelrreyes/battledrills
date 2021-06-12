import React, { useState, useEffect } from "react";
import { Checkbox, ArrowTooltip, TooltipPlacement } from "CORE";
import { useClickOutside } from "HOOKS";
import "./MultiSelect.scss";

export const MultiSelectSizes = {
	XXSMALL: "xxs",
	XSMALL: "xs",
	SMALL: "sm",
	MEDIUM: "md",
	LARGE: "lg",
	FILL: "fill"
};

export const MultiSelect = ({
	options,
	removeSelected = null,
	dropdownLabel = "Select Options",
	handleSelection,
	size = "md"
}) => {
	const [isDropdownVisible, setIsDropdownVisible] = useState(false);
	const [label, setLabel] = useState(dropdownLabel);
	const [selectedOptions, setSelectedOptions] = useState([]);
	const multiSelectRef = useClickOutside(() => {
		setIsDropdownVisible(false);
	});

	useEffect(() => {
		handleSelection(selectedOptions);
		if (selectedOptions.length === 1) {
			setLabel(`1 Drill Selected`);
		} else if (selectedOptions.length > 1) {
			setLabel(`${selectedOptions.length} Drills Selected`);
		} else {
			setLabel(dropdownLabel);
		}
	}, [selectedOptions]);

	/**
	 * Used for ReportsSelect (or when multiselect options depends on an outside source)
	 * Example: 3 drills, WCD1, WCD2, WCD3
	 * MultiSelect WCD1 then regular select WCD1
	 * This removes WCD1 from multiselect and comparable drills
	 */
	useEffect(() => {
		setSelectedOptions((prevOptions) => {
			return prevOptions.filter((val) => {
				return val !== removeSelected;
			});
		});
	}, [removeSelected]);

	const onDropdownClick = (e) => {
		e.stopPropagation();
		setIsDropdownVisible(!isDropdownVisible);
	};

	const isChecked = (option) => {
		return typeof option === "object" ? selectedOptions.includes(option.id) : selectedOptions.includes(option);
	};

	const renderOptions = () => {
		if (isDropdownVisible) {
			let items = options.map((option) => {
				// don't check if the content overflows here yet, but can do it with more work
				// will make a tooltip for all options
				if (typeof option === "object") {
					const { name, id } = option;
					return (
						<ArrowTooltip title={name} placement={TooltipPlacement.RIGHT} key={id}>
							<li className="select-item">
								<Checkbox
									label={name}
									initChecked={isChecked(option)}
									onChangeHandler={(checked) => {
										if (checked) {
											setSelectedOptions((prevOptions) => {
												return [...prevOptions, id];
											});
										} else {
											setSelectedOptions((prevOptions) => {
												return prevOptions.filter((val, index) => {
													return val !== id;
												});
											});
										}
									}}
								/>
							</li>
						</ArrowTooltip>
					);
				}
				return (
					<ArrowTooltip title={option} placement={TooltipPlacement.RIGHT} key={option}>
						<li className="select-item">
							<Checkbox
								label={option}
								initChecked={isChecked(option)}
								onChangeHandler={(checked) => {
									if (checked) {
										setSelectedOptions((prevOptions) => {
											return [...prevOptions, option];
										});
									} else {
										setSelectedOptions((prevOptions) => {
											return prevOptions.filter((val, index) => {
												return val !== option;
											});
										});
									}
								}}
							/>
						</li>
					</ArrowTooltip>
				);
			});

			return (
				<ul className="multi-select-list" onClick={(e) => e.stopPropagation()}>
					{items}
				</ul>
			);
		}
		return null;
	};

	return (
		<div className={`multi-select-wrapper-${size}`} ref={multiSelectRef}>
			<div className="multi-select-dropdown" onClick={onDropdownClick}>
				<span className="multi-select-label">{label}</span>
			</div>
			{renderOptions()}
		</div>
	);
};
