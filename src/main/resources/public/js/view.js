'use strict';

//app to draw polymorphic shapes on canvas
var app;
//var rotationangle = 0;
/**
 * Create the ball world app for a canvas
 * @param canvas The canvas to draw balls on
 * @returns {{drawBall: drawBall, clear: clear}}
 */
function createApp(canvas) {
    let c = canvas.getContext("2d");

    /**
     * Draw a circle
     * @param x  The x location coordinate
     * @param y  The y location coordinate
     * @param radius  The circle radius
     * @param color The circl color
     */
    let drawFish = function (x,y,radius) {
        let img = document.getElementById("im1")
        c.drawImage(img,x,y,radius,radius);
        c.rectStr
    }

    let drawRotatingFish= function (x,y,radius,rotate)
    {
        let img = document.getElementById("im1")
        c.setTransform(1, 0, 0, 1, x, y); // set the scale and the center pos
        c.rotate(rotate);
        c.drawImage(img, -x /2, -y /2,radius,radius); // draw image offset
                                                           // by half its width
                                                           // and heigth
        c.setTransform(1, 0, 0, 1, 0, 0); // restore default transform
    }
    let drawFlippedFish = function (x,y,radius) {

        let img = document.getElementById("im1")
        c.save();
        c.translate(x,y);
        c.rotate((180)*Math.PI/180);
        c.scale(1,-1);
        c.drawImage(img,-x/8,-y/8,radius,radius);
        c.restore();
    }
    let drawVerticalFish = function (x,y,radius) {

        let img = document.getElementById("im1")
        c.setTransform(1, 0, 0, 1, x, y); // set the scale and the center pos
        c.rotate((90/180)*Math.PI);
        c.drawImage(img, -x /2, -y /2,radius,radius); // draw image offset
        c.strokeRect(-x /2, -y /2, radius, radius)
        // by half its width
        // and heigth
        c.setTransform(1, 0, 0, 1, 0, 0); // restore default transform
    }
    let drawCircle = function(x, y, radius, color) {
        c.fillStyle = color;
        c.beginPath();
        c.arc(x, y, radius, 0, 2 * Math.PI, false);
        c.closePath();
        c.fill();
    };

    let drawTriangle = function(x, y, size, color) {
        c.fillStyle = color;
        c.beginPath();
        c.moveTo (x + size * Math.cos(0), y + size * Math.sin(0));

        for (let i = 1; i <= 3;i += 1) {
            c.lineTo (x + size * Math.cos(i * 2 * Math.PI / 3), y + size * Math.sin(i * 2 * Math.PI / 3));
        }
        c.closePath();
        c.fill();

    };

    let drawPolygon = function (x, y, radius, sides,color) {
        console.log("DrawPolygon Called");
        c.fillStyle = color;
        if (sides < 3) return;
        c.beginPath();
        var a = ((Math.PI * 2)/sides);
        // c.translate(x,y);
        c.moveTo (x + radius * Math.cos(0), y + radius * Math.sin(0));
        //c.moveTo(radius,0);
        for (let i = 1; i <sides; i++) {
            c.lineTo(x+radius*Math.cos(a*i),y+radius*Math.sin(a*i));
        }
        c.closePath();
        c.fill();
    }

    let drawRectangle = function (x,y,w,h,color)
    {
        c.fillStyle = color;
        c.fillRect(x, y, w, h);
    };

    let drawSquare = function (x,y,s,color)
    {
        console.log("Inside DrawSquare");
        c.fillStyle=color;
        c.fillRect(x, y, s, s);
    };

    let clear = function() {
        c.clearRect(0,0, canvas.width, canvas.height);
    };

    return {
        drawCircle: drawCircle,
        drawTriangle: drawTriangle,
        drawRectangle: drawRectangle,
        drawSquare: drawSquare,
        drawPolygon: drawPolygon,
        drawFish :drawFish,
        drawFlippedFish : drawFlippedFish,
        drawRotatingFish : drawRotatingFish,
        drawVerticalFish:drawVerticalFish,
        clear: clear,
        dims: {height: canvas.height, width: canvas.width}
    }
}


function hideInst() {
    document.getElementById("Instructions").style.display="none";
    document.getElementById("btn-show-inst").style.display="block";
    document.getElementById("btn-hide-inst").style.display="none";
}

function showInst() {
    document.getElementById("Instructions").style.display="block";
    document.getElementById("btn-hide-inst").style.display="block";
    document.getElementById("btn-show-inst").style.display="none";
}

window.onload = function() {
    app = createApp(document.querySelector("canvas"));

    $("#btn-load").click(loadBall);
    $("#btn-clear").click(clear);
    $("#btn-remove-some").click(removeSome);
    $("#btn-switch-strat").click(switchStrategy);
    // $("#btn-update").click(startUpdate)
    $("#btn-hide-inst").click(hideInst);
    $("#btn-show-inst").click(showInst)

    startUpdate();
    canvasDims();
    $("#btn-flip").click(flipFish);
    getStrategy();

    //Fish();
};
function flipFish() {

    app.drawFlippedFish(40,40,40,40);
    //app.drawFish(40,40,4,4);
}
function Flip()
{
    let shape = {name:'Fish'};
    drawShape(shape);
}

function startUpdate()
{
    setInterval(updateBallWorld,100);
}

/**
 * load ball at a location on the canvas
 */
function loadBall() {
    let types=getSides();
    let strategy = getStrategy();
    let switchable = getSwitchable();
    let removable = getRemovable();
    let colStrategy = getColStrategy();
    console.log(types);
    // $.post("/load", { strategies: values}, function (data) {
    // }, "json");
     $.post("/load", {type:types,strategy:strategy,colStrategy:colStrategy,switchable:switchable,removable:removable} ,function (data) {
         console.log(data);
         drawShape(data);
     }, "json");

}

function getSides()
{
    if(!(document.getElementById("sides").value==="")) {
        console.log(document.getElementById("sides").value);
        document.getElementById("btn-load").disabled = false;
    }
    else {
        document.getElementById("btn-load").disabled = true;
    }

    let sides=document.getElementById("sides").value;
    console.log("This is the Shape" + sides);
    return sides;
}

function getStrategy()
{
    let strategy = document.getElementById("strategy").value;
    console.log(strategy);
    return strategy;
}

function getColStrategy()
{
    let colstrategy = document.getElementById("colstrategy").value;
    console.log(colstrategy);
    return colstrategy;
}

function getSwitchable()
{
    const rbs = document.querySelectorAll('input[name="group1"]');
    let selectedValue;
    for (const rb of rbs) {
        if (rb.checked) {
            selectedValue = rb.value;
            break;
        }
    }
    console.log(selectedValue);
    return selectedValue;
}

function getRemovable() {
    const rbs = document.querySelectorAll('input[name="group2"]');
    let selectedValue;
    for (const rb of rbs) {
        if (rb.checked) {
            selectedValue = rb.value;
            break;
        }
    }
    console.log(selectedValue);
    return selectedValue;
}


 function switchStrategy() {

     $.post("/switch", function (data) {
            console.log("Strategies Switched");

     }, "json");
 }

function updateBallWorld() {
    $.get("/update", function(data) {
        let shapes = data;
        console.log(data);
        app.clear();
        for(let i=0;i<=data.length;i++)
        {
            drawShape(data[i]);
        }
    }, "json");
}

/**
 * Pass along the canvas dimensions
 */
function canvasDims() {
    $.post("/canvas/dims", {height: app.dims.height, width: app.dims.width});
}

/**
 * Clear the canvas
 */
function clear() {
    $.get("/clear");
    app.clear();
}

function removeSome() {
    $.get("/remove/some");
}

function drawShape(shape)
{
    console.log("Inside Draw Shape");
    switch(shape.name) {
        case "Circle":
            console.log("Inside Circle Draw case");
            app.drawCircle(shape.loc.x, shape.loc.y, shape.radius, shape.color)
            break;
        case "Triangle":
            //console.log("Inside Triangle Draw case");
            app.drawTriangle(shape.loc.x, shape.loc.y, shape.radius, shape.color);
            break;
        case "Square":
            console.log("Inside Square Draw case");
            app.drawSquare(shape.loc.x, shape.loc.y, shape.radius,shape.color);
            break;
        case "Pentagon":
            //console.log(shape);
            app.drawPolygon(shape.loc.x,shape.loc.y,shape.radius,5,shape.color);
            break;
        case "Hexagon":
            //console.log(shape);
            app.drawPolygon(shape.loc.x,shape.loc.y,shape.radius,6,shape.color);
            break;
        case "Fish":
            if(shape.isFlipped) {

                console.log("Drawing Flipped");
                app.drawFlippedFish(shape.loc.x,shape.loc.y,shape.radius);
                //app.drawVerticalFish(shape.loc.x, shape.loc.y, shape.radius)
            }
            // else if(shape.rotationAngle > 0){
            //     console.log("Drawing Rotating Fish");
            //     app.drawRotatingFish(shape.loc.x,shape.loc.y,shape.radius,shape.rotationAngle)
            // }
            // else if(shape.vel.x <= 0)
            // {
            //     console.log("Drawing Vertical");
            //     app.drawVerticalFish(shape.loc.x, shape.loc.y, shape.radius)
            // }
            else{
                console.log("Drawing unFlipped");
                // if(shape.vel.x=0)
                // {
                //     alert("X velocity 0")
                // }
                //app.drawVerticalFish(shape.loc.x, shape.loc.y, shape.radius)
                 app.drawFish(shape.loc.x, shape.loc.y, shape.radius);
                //app.drawFish(shape.loc.x, shape.loc.y, shape.radius);
            }
            break;
        default:
            null;
    }
    function hideInst(){



    }
    function  showInst(){

        document.getElementById("Instructions").style.display="block";
    }
}