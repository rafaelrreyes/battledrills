import React, { useEffect, useState, useRef } from "react";
import ReactDOM from "react-dom";
import joint from "jointjs/index";
import { createPaletteOptions } from "../../joint/DrillEditorUtils";

import "./DrillEditorView.scss";

const DEFAULTS = {

};

const DrillEditorView = ({ battleDrillDiagram, diagramGraph, diagramPaper }) => {
    const editorViewRef = useRef(null);
    const paletteGraph = new joint.dia.Graph;
    let palettePaper;

    useEffect(() => {
        palettePaper = new joint.dia.Paper({
            el: ReactDOM.findDOMNode(editorViewRef.current),
            model: paletteGraph,
            height: 100, // TODO make this as big as it needs to be
            interactive: false
        });

        createPaletteOptions(battleDrillDiagram, diagramGraph, diagramPaper, paletteGraph, palettePaper);
    }, [diagramPaper, battleDrillDiagram]);

    return (
        <div className="editor-view">
            <div className="palette" id="palette" ref={editorViewRef}></div>
        </div>
    )
};

export default DrillEditorView;