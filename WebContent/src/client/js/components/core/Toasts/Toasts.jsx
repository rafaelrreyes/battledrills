import React from "react";
import PropTypes from "prop-types";
import { Toast } from "./Toast";
import { TransitionGroup } from "react-transition-group";
import "./Toasts.scss";

const Toasts = ({ toasts }) => {
	return (
		<div className="toasts">
			<TransitionGroup>{renderToasts(toasts)}</TransitionGroup>
		</div>
	);
};

const renderToasts = (toasts) => {
	if (toasts.length > 0) {
		return toasts.map((toast) => {
			const { toastId } = toast;
			return <Toast key={toastId} {...toast} />;
		});
	}
};

export default Toasts;

Toasts.propTypes = {
	toasts: PropTypes.arrayOf(
		PropTypes.shape({
			delay: PropTypes.number,
			message: PropTypes.string,
			toastType: PropTypes.string,
			user: PropTypes.shape({
				username: PropTypes.string,
				sessionId: PropTypes.string,
				role: PropTypes.string
			}),
			taskData: PropTypes.shape({
				currentStatus: PropTypes.string,
				taskId: PropTypes.string,
				taskDescription: PropTypes.string
			}),
			drillName: PropTypes.string,
			operationType: PropTypes.string,
			objectType: PropTypes.string,
			note: PropTypes.shape({
				noteText: PropTypes.string,
				user: PropTypes.shape({
					username: PropTypes.string,
					sessionId: PropTypes.string,
					role: PropTypes.string
				}),
				id: PropTypes.string,
				type: PropTypes.string,
				timestampMillis: PropTypes.number
			})
		})
	)
};
