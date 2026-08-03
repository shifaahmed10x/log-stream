import { Paper, Box } from "@mui/material";

function GlassCard({ children, sx = {} }) {
  return (
    <Paper
      elevation={0}
      sx={{
        position: "relative",

        overflow: "hidden",

        p: 3,

        borderRadius: "24px",

        background:
          "linear-gradient(180deg, rgba(255,255,255,0.05), rgba(255,255,255,0.025))",

        backdropFilter: "blur(24px)",

        border: "1px solid rgba(255,255,255,0.06)",

        boxShadow: "0 12px 40px rgba(0,0,0,0.20)",

        transition: "all .35s ease",

        "&:hover": {
          transform: "translateY(-6px)",

          borderColor: "rgba(139,92,246,.35)",

          boxShadow: "0 22px 55px rgba(139,92,246,.18)",
        },

        ...sx,
      }}
    >
      {/* Decorative Glow */}

      <Box
        sx={{
          position: "absolute",

          top: -90,

          right: -90,

          width: 180,

          height: 180,

          borderRadius: "50%",

          background:
            "radial-gradient(circle, rgba(139,92,246,.22), transparent 70%)",

          filter: "blur(40px)",

          pointerEvents: "none",
        }}
      />

      {children}
    </Paper>
  );
}

export default GlassCard;