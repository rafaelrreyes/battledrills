import React, { Component } from "react";
import PropTypes from "prop-types";
import { Button, ButtonSizes, ButtonTypes } from "../Button/Button";
import { Icon } from "../Icon/Icon";
import "./Modal.scss";
import { MaterialIconNames } from "UTILITIES";

export const Modal = ({ close, children, singleButton, submit, disable, acceptText }) => {
	return (
		<div className="c2pc-modal">
			<div className="modal-content">
				<Icon className="modal-close" onClick={close}>
					{MaterialIconNames.CLOSE}
				</Icon>
				<div className="modal-data">{children}</div>
				<div className="modal-btns">
					{!singleButton && (
						<>
							<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.GREY} onClick={close}>
								Cancel
							</Button>
							<Button
								buttonSize={ButtonSizes.MEDIUM}
								buttonType={ButtonTypes.REGULAR}
								onClick={submit}
								isDisabled={disable}
							>
								{acceptText}
							</Button>
						</>
					)}
					{singleButton && (
						<Button buttonSize={ButtonSizes.MEDIUM} buttonType={ButtonTypes.REGULAR} onClick={close}>
							OK
						</Button>
					)}
				</div>
			</div>
		</div>
	);
};

Modal.defaultProps = {
	singleButton: false
};

Modal.propTypes = {
	close: PropTypes.func.isRequired,
	children: PropTypes.element.isRequired,
	submit: PropTypes.func,
	singleButton: PropTypes.bool
};
