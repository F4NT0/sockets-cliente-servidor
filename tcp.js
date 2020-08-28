/*
    To run:
        Run this file using node.js

    Open terminal and type:
        > brew install telnet
        > telnet 127.0.0.1 8080

*/

const net = require("net");

const server = net.createServer(socket => {
    socket.write("Hello.");
    socket.on("data", data => {
        console.log(data.toString());
    })
} )

server.listen(8080);
