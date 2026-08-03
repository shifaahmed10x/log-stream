import { useEffect, useState } from "react";
import ReactECharts from "echarts-for-react";

import {
  getApplicationCount,
  getLogLevelCount,
  getLogsPerDay,
} from "../services/analyticsService";

function Analytics() {

  const [levelData, setLevelData] = useState([]);
  const [applicationData, setApplicationData] = useState([]);
  const [timelineData, setTimelineData] = useState([]);

  useEffect(() => {

    const loadData = async () => {

      try {

        const levels = await getLogLevelCount();
        const apps = await getApplicationCount();
        const timeline = await getLogsPerDay();

        setLevelData(levels);
        setApplicationData(apps);
        setTimelineData(timeline);

      } catch (error) {
        console.error(error);
      }

    };

    loadData();

  }, []);

  const pieOption = {
    tooltip: {
      trigger: "item",
    },
    legend: {
      top: "5%",
      left: "center",
      textStyle: {
        color: "#fff",
      },
    },
    series: [
      {
        name: "Logs",
        type: "pie",
        radius: ["40%", "70%"],
        data: levelData.map(item => ({
          value: item.count,
          name: item.logLevel,
        })),
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
          },
        },
        label: {
          color: "#fff",
        },
      },
    ],
  };

  const barOption = {
    title: {
      text: "Application Distribution",
      left: "center",
    },
    xAxis: {
      type: "category",
      data: applicationData.map(item => item.applicationName),
    },
    yAxis: {
      type: "value",
    },
    series: [
      {
        type: "bar",
        data: applicationData.map(item => item.count),
      },
    ],
  };

  const lineOption = {
    title: {
      text: "Logs Per Day",
      left: "center",
    },
    xAxis: {
      type: "category",
      data: timelineData.map(item => item.date),
    },
    yAxis: {
      type: "value",
    },
    series: [
      {
        type: "line",
        smooth: true,
        data: timelineData.map(item => item.count),
      },
    ],
  };

  console.log(levelData);
  console.log(applicationData);
  console.log(timelineData);

  return (

    <div style={{ padding: 20 }}>

      <h1>Analytics Dashboard</h1>

      <div
        style={{
          display: "grid",
          gridTemplateColumns: "1fr 1fr",
          gap: 20,
        }}
      >

        <ReactECharts option={pieOption} style={{ height: 400 }} />

        <ReactECharts option={barOption} style={{ height: 400 }} />

      </div>

      <div style={{ marginTop: 30 }}>

        <ReactECharts option={lineOption} style={{ height: 400 }} />

      </div>

    </div>

  );

}

export default Analytics;