import { Pool } from "pg";

export const pool = new Pool({
    port: 5432,
    host: "localhost",
    database: 'pernstack',
    user: "postgres",
    password: "1234",
});

pool.on("connect", () => {
    console.log("conectado a la base de datos");
});