import {
  AppBar,
  Toolbar,
  Typography,
  Avatar,
  Box,
  IconButton,
} from "@mui/material";

import { Moon, Sun } from "lucide-react";

import { useAppTheme } from "../../context/ThemeContext";
function Navbar() {
  const { mode, toggleTheme } = useAppTheme();

  return (
    <AppBar
      position="sticky"
      elevation={0}
      sx={{
        background: "rgba(18,18,18,0.75)",
        backdropFilter: "blur(18px)",
        borderBottom: "1px solid rgba(255,255,255,0.06)",
      }}
    >
      <Toolbar
        sx={{
          justifyContent: "space-between",
          height: 76,
        }}
      >
        <Box>
          <Typography
            variant="h5"
            sx={{
              fontWeight: 700,
              color: "text.primary",
              letterSpacing: "-0.5px",
            }}
          >
            Distributed Log Analytics
          </Typography>

          <Typography
            variant="body2"
            sx={{
              color: "text.secondary",
              mt: 0.3,
            }}
          >
            Monitor • Search • Analyze Logs
          </Typography>
        </Box>

        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            gap: 2,
          }}
        >
          <Typography
            sx={{
              color: "text.secondary",
              fontWeight: 500,
            }}
          >
            {new Date().toLocaleTimeString()}
          </Typography>

          <IconButton
            onClick={toggleTheme}
            sx={{
              width: 42,
              height: 42,
              color: "primary.main",
              bgcolor: "background.paper",
              border: "1px solid rgba(255,255,255,.08)",

              "&:hover": {
                bgcolor: "action.hover",
              },
            }}
          >
            {mode === "dark" ? (
              <Sun size={18} />
            ) : (
              <Moon size={18} />
            )}
          </IconButton>

          <Avatar
            sx={{
              width: 42,
              height: 42,

              background:
                "linear-gradient(135deg,#8B5CF6,#A855F7)",

              fontWeight: 700,

              boxShadow:
                "0 10px 30px rgba(139,92,246,.35)",
            }}
          >
            S
          </Avatar>
        </Box>
      </Toolbar>
    </AppBar>
  );
}

export default Navbar;