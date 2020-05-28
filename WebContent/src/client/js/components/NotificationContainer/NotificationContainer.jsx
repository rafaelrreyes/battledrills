import React from "react";
import { useSelector } from "react-redux";
import { Toasts } from "CORE";
import { getToasts } from "REDUX";

const NotificationContainer = () => {
	const toasts = useSelector(getToasts);

	return <Toasts toasts={toasts} />;
};

export default NotificationContainer;
