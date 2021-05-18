import { combineReducers } from "redux";
import AllDrills from "./AllDrills/AllDrillsReducer";
import Modal from "./Modal/ModalReducer";
import SelectedDrill from "./SelectedDrill/SelectedDrillReducer";
import Websocket from "./Websocket/WebsocketReducer";
import Tasks from "./Tasks/TasksReducer";
import User from "./User/UserReducer";
import Chat from "./Chat/ChatReducer";
import AllStatus from "./AllStatus/AllStatusReducer";
import Billet from "./Billet/BilletReducer";
import View from "./View/ViewReducer";
import DiagramEditor from "./DiagramEditor/DiagramEditorReducer";
import Roles from "./Roles/RolesReducer";
import Groups from "./Groups/GroupsReducer";

export * from "./AllDrills/AllDrillsActions";
export * from "./AllDrills/AllDrillsSelectors";
export * from "./Modal/ModalActions";
export * from "./Modal/ModalSelectors";
export * from "./SelectedDrill/SelectedDrillActions";
export * from "./SelectedDrill/SelectedDrillSelectors";
export * from "./Websocket/WebsocketActions";
export * from "./Websocket/WebsocketSelectors";
export * from "./Tasks/TasksActions";
export * from "./Tasks/TasksSelectors";
export * from "./User/UserActions";
export * from "./User/UserSelectors";
export * from "./Chat/ChatActions";
export * from "./Chat/ChatSelectors";
export * from "./AllStatus/AllStatusActions";
export * from "./AllStatus/AllStatusSelectors";
export * from "./Billet/BilletActions";
export * from "./Billet/BilletSelectors";
export * from "./View/ViewActions";
export * from "./View/ViewSelectors";
export * from "./DiagramEditor/DiagramEditorActions";
export * from "./DiagramEditor/DiagramEditorSelectors";
export * from "./Roles/RolesActions";
export * from "./Roles/RolesSelectors";
export * from "./Groups/GroupsActions";
export * from "./Groups/GroupsSelectors";

export default combineReducers({
	AllDrills,
	Modal,
	SelectedDrill,
	Websocket,
	Tasks,
	User,
	Chat,
	AllStatus,
	Billet,
	View,
	DiagramEditor,
	Roles,
	Groups
});
