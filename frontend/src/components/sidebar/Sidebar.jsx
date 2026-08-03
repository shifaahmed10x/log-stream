import { Box, Typography, Divider, List } from "@mui/material";

import {
  LayoutDashboard,
  Search,
  BarChart3,
  Terminal,
} from "lucide-react";

import SidebarItem from "./SidebarItem";

function Sidebar() {
  return (
    <Box
      sx={{
        width: 280,
        minHeight: "100vh",
        background: "#141414",
        borderRight: "1px solid rgba(255,255,255,.06)",
        px: 2.5,
        py: 3,
      }}
    >
      {/* Logo */}

      <Typography
        variant="h4"
        fontWeight={800}
        sx={{
          color: "#F8F8F8",
          letterSpacing: 1,
          px: 2,
          mb: 4,
        }}
      >
        LOG STREAM
      </Typography>

      <Divider
        sx={{
          borderColor: "rgba(255,255,255,.06)",
          mb: 4,
        }}
      />

      <List>

        <SidebarItem
          title="Dashboard"
          to="/"
          icon={<LayoutDashboard size={20} />}
        />

        <SidebarItem
          title="Search Logs"
          to="/search"
          icon={<Search size={20} />}
        />

        <SidebarItem
          title="Analytics"
          to="/analytics"
          icon={<BarChart3 size={20} />}
        />

        <SidebarItem
          title="Live Tail"
          to="/live-tail"
          icon={<Terminal size={20} />}
        />


      </List>
    </Box>
  );
}

export default Sidebar;