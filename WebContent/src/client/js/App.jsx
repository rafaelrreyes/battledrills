import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { withRouter } from "react-router-dom";
import { hot } from "react-hot-loader/root";
import { useLocalStorage } from "HOOKS";
import { MuiThemeProvider, createMuiTheme } from "@material-ui/core/styles";
import { Header, Main, Footer } from "COMPONENTS";
import { ModalContainer } from "CORE";
import { WS, SUPPORTED_WS_EVENT_TYPES, dispatchWebsocket } from "UTILITIES";
import { setUser } from "REDUX";

//css
import "./App.scss";

const App = () => {
	const dispatch = useDispatch();
	const [loggedInUser, setLoggedInUser] = useLocalStorage("user", { username: "WO", role: "WO" });
	let websocket;

	useEffect(() => {
		dispatch(setUser(loggedInUser));
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

	// only thing changed is zindex for tooltip
	// if we do themes via material ui later, can set the colors here
	// https://material-ui.com/customization/default-theme/
	const theme = createMuiTheme({
		zIndex: {
			tooltip: 2147483647
		}
	});

	return (
		<MuiThemeProvider theme={theme}>
			<Header />
			<Main />
			<Footer />
			<ModalContainer />
		</MuiThemeProvider>
	);
};

export default withRouter(hot(App));
