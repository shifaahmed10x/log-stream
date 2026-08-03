import {
  AppBar,
  Toolbar,
  Typography,
  Avatar,
  Box,
  IconButton,
} from "@mui/material";

import { Moon } from "lucide-react";

function Navbar() {
  return (
    <AppBar
      position="sticky"
      elevation={0}
      sx={{
        background: "rgba(20,20,20,.75)",
        backdropFilter: "blur(18px)",
        borderBottom: "1px solid rgba(255,255,255,.06)",
      }}
    >
      <Toolbar
        sx={{
          justifyContent: "space-between",
          height: 76,
        }}
      >
        <Typography
          variant="h4"
          fontWeight={700}
          sx={{
            color: "#fff",
          }}
        >
          Distributed Log Analytics
        </Typography>

        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            gap: 2,
          }}
        >
          <Typography
            sx={{
              color: "#8D8D8D",
            }}
          >
            {new Date().toLocaleTimeString()}
          </Typography>

          <IconButton
            sx={{
              color: "#C084FC",
              bgcolor: "rgba(255,255,255,.05)",

              "&:hover": {
                bgcolor: "rgba(255,255,255,.08)",
              },
            }}
          >
            <Moon size={20} />
          </IconButton>

          <Avatar
            sx={{
              bgcolor: "#7C3AED",
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