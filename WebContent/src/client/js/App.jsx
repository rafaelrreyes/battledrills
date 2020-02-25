import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { withRouter } from "react-router-dom";
import { hot } from "react-hot-loader/root";
import { Header, Main, Footer, ModalContainer } from "./components/index";
import { WS, SUPPORTED_WS_EVENT_TYPES, dispatchWebsocket } from "UTILITIES/index";
import { setUser } from "REDUX/index";

//css
import "./App.scss";

const App = () => {
	const dispatch = useDispatch();
	let websocket;

	useEffect(() => {
		dispatch(setUser({ username: "WO", role: "WO" }));
		// set up WS subscriber here
		setupWebsocket();
	}, []);

	const setupWebsocket = () => {
		websocket = WS();
		websocket.getInstance();
		websocket.addListener(SUPPORTED_WS_EVENT_TYPES.OPEN, () => {
			console.log("Websocket connected successfully.");
		});

		websocket.addListener(SUPPORTED_WS_EVENT_TYPES.CLOSE, () => {
			console.log(`Websocket connection closed.`);
		});

		websocket.addListener(SUPPORTED_WS_EVENT_TYPES.ERROR, () => {
			console.error(`An error occured with the websocket connection.`);
		});

		websocket.addListener(SUPPORTED_WS_EVENT_TYPES.MESSAGE, (response) => {
			const json = JSON.parse(response.data);
			dispatchWebsocket(json);
		});
	};

	return (
		<>
			<div className="app-wrapper-div">
				<Header />
				<Main />
				<Footer />
			</div>
			<ModalContainer />
		</>
	);
};

export default withRouter(hot(App));
