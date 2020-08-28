/*
    To run:
        Run this file using node.js

    Open terminal and type:
        > echo "hi" | nc -w1 -u 127.0.0.1 8081

*/

const dgram = require('dgram');
const socket = dgram.createSocket('udp4');

socket.on('message', (msg, rinfo) => {
    console.log(`server got: ${msg} from ${rinfo.address}:${rinfo.port}`);
})

socket.bind(8081);
