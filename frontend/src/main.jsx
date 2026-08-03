import global from "global";

window.global = global;

import React from "react";
import ReactDOM from "react-dom/client";

import { CssBaseline } from "@mui/material";

import App from "./App";

import { CustomThemeProvider } from "./context/ThemeContext";

import "./styles/global.css";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <CustomThemeProvider>
      <CssBaseline />
      <App />
    </CustomThemeProvider>
  </React.StrictMode>
);