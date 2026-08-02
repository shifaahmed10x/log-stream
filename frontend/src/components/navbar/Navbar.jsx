import { AppBar, Toolbar, Typography, Box, Avatar } from "@mui/material";

function Navbar() {
  return (
    <AppBar
      position="static"
      elevation={0}
      sx={{
        backgroundColor: "#111827",
        borderBottom: "1px solid #374151",
      }}
    >
      <Toolbar sx={{ justifyContent: "space-between" }}>
        <Typography variant="h5" color="white">
          Distributed Log Analytics
        </Typography>

        <Box display="flex" alignItems="center" gap={2}>
          <Typography color="#9CA3AF">
            {new Date().toLocaleTimeString()}
          </Typography>

          <Avatar sx={{ bgcolor: "#0F766E" }}>
            S
          </Avatar>
        </Box>
      </Toolbar>
    </AppBar>
  );
}

export default Navbar;