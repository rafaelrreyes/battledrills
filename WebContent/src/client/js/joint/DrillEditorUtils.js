import joint from "jointjs/index";
import { ShapesConstants } from "./ShapesHelper";
import $ from "jquery";
import Shapes from "./Shapes";

export const createPaletteOptions = (battleDrillDiagram, diagramGraph, diagramPaper, paletteGraph, palettePaper) => {
    var r1 = new joint.shapes.basic.Rect({
        position: {
          x: 10,
          y: 10
        },
        size: {
          width: 100,
          height: 40
        },
        attrs: {
          text: {
            text: 'Rect1'
          }
        }
      });
      var r2 = new joint.shapes.basic.Rect({
        position: {
          x: 120,
          y: 10
        },
        size: {
          width: 100,
          height: 40
        },
        attrs: {
          text: {
            text: 'Rect2'
          }
        }
      });
    
    const contributorRect = new joint.shapes.standard.Rectangle({
        position: {
            x: 10,
            y: 10
        },
        size: {
            width: 100,
            height: 40
        },
        attrs: {
            text: {
                text: "<role>",
                fontWeight: "bolder",
                fontFamily: "Roboto"
            },
            body: {
                fill: ShapesConstants.CONTRIBUTOR_COLOR,
                filter: {
                    name: "dropShadow",
                    args: {
                        dx: 2,
                        dy: 2,
                        blur: 3
                    }
                }
            }
        }
    });

    const taskBlock = new joint.shapes.html.ActionBlock({
        template: [
            '<div class="action-items-container">',
            '<div class="draggable-tasks">&lttasks&gt</div>',
            '<ul class="action-items"></ul>',
            "</div>"
        ].join(""),
        position: {
            x: 120,
            y: 10
        },
        size: {
            width: ShapesConstants.ACTION_BLOCK_WIDTH,
            height: ShapesConstants.ACTION_BLOCK_HEIGHT
        },
        attrs: {
            list: [],
            body: {
                strokeWidth: 0
            }
        }
    });

    paletteGraph.addCells([r1, r2]);

    palettePaper.on('cell:pointerdown', function(cellView, e, x, y) {
        $('body').append('<div id="flyPaper" style="position:fixed;z-index:100;opacity:.7;pointer-event:none;"></div>');
        var flyGraph = new joint.dia.Graph,
          flyPaper = new joint.dia.Paper({
            el: $('#flyPaper'),
            model: flyGraph,
            interactive: false
          }),
          flyShape = cellView.model.clone(),
          pos = cellView.model.position(),
          offset = {
            x: x - pos.x,
            y: y - pos.y
          };
      
        flyShape.position(0, 0);
        flyGraph.addCell(flyShape);
        $("#flyPaper").offset({
          left: e.pageX - offset.x,
          top: e.pageY - offset.y
        });
        $('body').on('mousemove.fly', function(e) {
          $("#flyPaper").offset({
            left: e.pageX - offset.x,
            top: e.pageY - offset.y
          });
        });

        $('body').on('mouseup.fly', function(e) {
          var x = e.pageX,
            y = e.pageY,
            target = diagramPaper.$el.offset();
          
          // Dropped over paper ?
          if (x > target.left && x < target.left + diagramPaper.$el.width() && y > target.top && y < target.top + diagramPaper.$el.height()) {
            var s = flyShape.clone();
            s.position(x - target.left - offset.x, y - target.top - offset.y);
            console.log(`adding to diagram paper`);
            diagramGraph.addCell(s);
            // battleDrillDiagram.addElement(s);
            // console.log(battleDrillDiagram.getCells());
            // diagramGraph.resetCells();
          }
          $('body').off('mousemove.fly').off('mouseup.fly');
          flyShape.remove();
          $('#flyPaper').remove();
        });
      });
};