import { Typography, Box } from "@mui/material";
import StatCard from "../components/cards/StatCard";
import RecentLogsTable from "../components/tables/RecentLogsTable";
import LogLevelChart from "../components/charts/LogLevelChart";
import LogsTimelineChart from "../components/charts/LogsTimelineChart";

function Dashboard() {
  return (
    <>
      <Typography
        variant="h3"
        fontWeight="bold"
        color="white"
        mb={4}
      >
        Dashboard
      </Typography>

      <Box
        sx={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
          gap: 3,
        }}
      >
        <StatCard title="Total Logs" value="12,450" color="#14B8A6" />
        <StatCard title="Error Logs" value="320" color="#EF4444" />
        <StatCard title="Warning Logs" value="1,120" color="#F59E0B" />
        <StatCard title="Info Logs" value="11,010" color="#22C55E" />
      </Box>
      <RecentLogsTable/>
      <Box
        mt={4}
        sx={{
          display: "grid",
          gridTemplateColumns: {
            xs: "1fr",
            md: "1fr 1fr",
          },
          gap: 3,
        }}
      >
        <Box
          sx={{
            background: "#111827",
            p: 3,
            borderRadius: 3,
          }}
        >
          <Typography
            variant="h6"
            color="white"
            mb={2}
          >
            Log Level Distribution
          </Typography>

          <LogLevelChart />
        </Box>

        <Box
          sx={{
            background: "#111827",
            p: 3,
            borderRadius: 3,
          }}
        >
          <Typography
            variant="h6"
            color="white"
            mb={2}
          >
            Log Volume Timeline
          </Typography>

          <LogsTimelineChart />
        </Box>
      </Box>
    </>
  );
}

export default Dashboard;