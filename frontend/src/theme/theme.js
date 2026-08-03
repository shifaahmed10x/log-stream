import { createTheme } from "@mui/material/styles";

export const createAppTheme = (palette) =>

    createTheme({

        palette,

        shape: {

            borderRadius: 18,

        },

        typography: {

            fontFamily: "Manrope",

            h4: {

                fontWeight: 700,

            },

            h5: {

                fontWeight: 700,

            },

            button: {

                textTransform: "none",

                fontWeight: 600,

            },

        },

    });
