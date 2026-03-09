const express = require("express");
const app = express();

app.use(express.json());

let users = [
    { id: 1, name: "Arun" },
    { id: 2, name: "Rahul" }
];

// GET all users
app.get("/users", (req, res) => {
    res.json(users);
});

// GET single user
app.get("/users/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const user = users.find(u => u.id === id);

    if (!user) {
        return res.status(404).json({ message: "User not found" });
    }

    res.json(user);
});

// POST - create new user
app.post("/users", (req, res) => {
    const user = req.body;
    users.push(user);

    res.status(201).json({
        message: "User added",
        user
    });
});

// PUT - update full user
app.put("/users/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const index = users.findIndex(u => u.id === id);

    if (index === -1) {
        return res.status(404).json({ message: "User not found" });
    }

    users[index] = req.body;

    res.json({
        message: "User fully updated",
        user: users[index]
    });
});

// PATCH - update partial user
app.patch("/users/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const user = users.find(u => u.id === id);

    if (!user) {
        return res.status(404).json({ message: "User not found" });
    }

    Object.assign(user, req.body);

    res.json({
        message: "User partially updated",
        user
    });
});

// DELETE user
app.delete("/users/:id", (req, res) => {
    const id = parseInt(req.params.id);
    users = users.filter(u => u.id !== id);

    res.json({
        message: "User deleted"
    });
});

// Start server
app.listen(3000, () => {
    console.log("Server running on port 3000");
});