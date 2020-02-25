import { useSelector } from "react-redux";
import { Toasts } from "../index";
import React from "react";
import { getToasts } from "REDUX/index";

const NotificationContainer = () => {
	const toasts = useSelector(getToasts);

	return <Toasts toasts={toasts} />;
};

export default NotificationContainer;
