import { Typography, Box } from "@mui/material";
import { useEffect, useState } from "react";

import StatCard from "../components/cards/StatCard";
import RecentLogsTable from "../components/tables/RecentLogsTable";
import LogLevelChart from "../components/charts/LogLevelChart";
import LogsTimelineChart from "../components/charts/LogsTimelineChart";

import { searchLogs } from "../services/logService";

function Dashboard() {
  const [searchResponse, setSearchResponse] = useState(null);

  useEffect(() => {
    loadLogs();
  }, []);

  const loadLogs = async () => {
    try {
      const data = await searchLogs({
        keyword: "",
        applicationName: "",
        serviceName: "",
        hostName: "",
        logLevel: "",
        loggerName: "",
        threadName: "",
        startDate: null,
        endDate: null,
        page: 0,
        pageSize: 10,
        sortBy: "timestamp",
        sortDirection: "desc",
      });

      console.log("API Response:", data);
      setSearchResponse(data);
    } catch (error) {
      console.error("API Error:", error);
    }
  };
const logs = searchResponse?.logs || [];

const errorCount = logs.filter(
  (log) => log.logLevel === "ERROR"
).length;

const warningCount = logs.filter(
  (log) => log.logLevel === "WARN"
).length;

const infoCount = logs.filter(
  (log) => log.logLevel === "INFO"
).length;

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
      <StatCard
        title="Total Logs"
        value={searchResponse?.totalRecords ?? 0}
        color="#14B8A6"
      />
        <StatCard
          title="Error Logs"
          value={errorCount}
          color="#EF4444"
        />

        <StatCard
          title="Warning Logs"
          value={warningCount}
          color="#F59E0B"
        />

        <StatCard
          title="Info Logs"
          value={infoCount}
          color="#22C55E"
        />
      </Box>

      <RecentLogsTable logs={searchResponse?.logs || []} />

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
          <Typography variant="h6" color="white" mb={2}>
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
          <Typography variant="h6" color="white" mb={2}>
            Log Volume Timeline
          </Typography>

          <LogsTimelineChart />
        </Box>
      </Box>
    </>
  );
}

export default Dashboard;