export const signin = (req, res) => {
    res.json({ message: "Iniciando sesión", data: req.body });
};

export const signup = (req, res) => {
    res.json({ message: "Registrando nuevo usuario", data: req.body });
};

export const signout = (req, res) => {
    res.json({ message: "Cerrando sesión" });
};

export const profile = (req, res) => {
    res.json({ message: "Obteniendo perfil del usuario" });
};