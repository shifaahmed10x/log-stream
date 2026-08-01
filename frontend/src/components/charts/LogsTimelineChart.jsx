import ReactECharts from "echarts-for-react";

function LogsTimelineChart() {
  const option = {
    backgroundColor: "transparent",

    tooltip: {
      trigger: "axis",
    },

    xAxis: {
      type: "category",
      data: ["10 AM", "11 AM", "12 PM", "1 PM", "2 PM", "3 PM"],
      axisLabel: {
        color: "#D1D5DB",
      },
      axisLine: {
        lineStyle: {
          color: "#374151",
        },
      },
    },

    yAxis: {
      type: "value",
      axisLabel: {
        color: "#D1D5DB",
      },
      splitLine: {
        lineStyle: {
          color: "#1F2937",
        },
      },
    },

    series: [
      {
        data: [120, 200, 150, 280, 350, 420],
        type: "line",
        smooth: true,
        lineStyle: {
          color: "#14B8A6",
          width: 3,
        },
        itemStyle: {
          color: "#14B8A6",
        },
      },
    ],
  };

  return <ReactECharts option={option} style={{ height: 350 }} />;
}

export default LogsTimelineChart;