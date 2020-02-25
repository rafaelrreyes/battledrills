import React from "react";
import ReactDOM from "react-dom";
import { HashRouter } from "react-router-dom";
import App from "./client/js/App";
import "./client/lib/backbone.js";
import "./client/lib/lodash.js";
import { Provider } from "react-redux";
import store from "./client/js/redux/store";
import "./client/css/main.scss";

ReactDOM.render(
	<Provider store={store}>
		<HashRouter>
			<App />
		</HashRouter>
	</Provider>,
	document.getElementById("index")
);
