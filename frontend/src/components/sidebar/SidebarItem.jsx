import { ListItemButton, ListItemIcon, ListItemText } from "@mui/material";
import { NavLink } from "react-router-dom";

function SidebarItem({ title, to, icon }) {
  return (
    <ListItemButton
      component={NavLink}
      to={to}
      sx={{
        color: "#B8B8B8",
        borderRadius: "16px",
        mb: 1.2,
        py: 1.5,
        px: 1,

        transition: ".25s",

        "&.active": {
          background:
            "linear-gradient(135deg,#7C3AED,#9333EA)",
          color: "#fff",
          boxShadow: "0 10px 30px rgba(124,58,237,.35)",
        },

        "&:hover": {
          background: "rgba(255,255,255,.05)",
          color: "#fff",
          transform: "translateX(4px)",
        },
      }}
    >
      <ListItemIcon
        sx={{
          color: "inherit",
          minWidth: 42,
        }}
      >
        {icon}
      </ListItemIcon>

      <ListItemText primary={title} />
    </ListItemButton>
  );
}

export default SidebarItem;