import {
  ListItemButton,
  ListItemIcon,
  ListItemText,
} from "@mui/material";

import { NavLink } from "react-router-dom";

function SidebarItem({ title, to, icon }) {
  return (
    <ListItemButton
      component={NavLink}
      to={to}
      sx={{
        height: 54,

        borderRadius: "16px",

        color: "text.secondary",

        transition: ".25s",

        "& .MuiListItemText-primary": {
          fontWeight: 500,
        },

        "&.active": {
          color: "#fff",

          background:
          "linear-gradient(135deg,#8B5CF6,#A855F7)",

          boxShadow:
            "0 10px 30px rgba(124,58,237,.25)",
        },

        "&:hover": {
          background: "rgba(255,255,255,.05)",

          color: "text.primary",
        },
      }}
    >
      <ListItemIcon
        sx={{
          color: "inherit",
          minWidth: 38,
        }}
      >
        {icon}
      </ListItemIcon>

      <ListItemText primary={title} />
    </ListItemButton>
  );
}

export default SidebarItem;