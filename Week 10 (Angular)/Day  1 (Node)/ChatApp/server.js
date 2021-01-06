const http = require("http");
const express = require("express");
const path = require("path");

const app = express();

const PORT = 3010;

const server = http.createServer(app);
app.use(express.static(path.join(__dirname, "public")));
app.use(express.static(path.join(__dirname, "node_modules")));

server.listen(PORT, () => {
  console.log("Express server started at 3010");
});

//handshake -> server and client

const io = require("socket.io")(server);

//handler

io.on("connection", (socket) => {
  socket.on("msg", (msg) => {
    // console.log(msg);
    socket.broadcast.emit("server-msg", msg);
  });
});
