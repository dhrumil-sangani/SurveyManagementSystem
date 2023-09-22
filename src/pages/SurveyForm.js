import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Drawer, Button, Table, Space } from "antd";
import {
  LikeOutlined,
  PlusOutlined,
  EditOutlined,
  DeleteOutlined,
  UserAddOutlined,
} from "@ant-design/icons";
import CustomGoogleForms from "../component/SurveyForm/CustomGoogleForms";

const SurveyForm = () => {
  const navigate = useNavigate();

  const redirectToCreateForm = () => {
    navigate("/SurveyCreate");
  };

  const [open, setOpen] = useState(false);

  // Sample data for the DataTable
  const dataSource = [
    {
      key: "1",
      name: "Survey 1",
      startDate: "2023-08-01",
      endDate: "2023-08-15",
    },
    {
      key: "2",
      name: "Survey 2",
      startDate: "2023-09-01",
      endDate: "2023-09-15",
    },
    {
      key: "3",
      name: "Survey 3",
      startDate: "2023-10-01",
      endDate: "2023-10-15",
    },
    {
      key: "4",
      name: "Survey 4",
      startDate: "2023-10-01",
      endDate: "2023-10-15",
    },
    {
      key: "5",
      name: "Survey 5",
      startDate: "2023-10-01",
      endDate: "2023-10-15",
    },
    {
      key: "6",
      name: "Survey 6",
      startDate: "2023-10-01",
      endDate: "2023-10-15",
    },
  ];

  const columns = [
    {
      title: "No.",
      dataIndex: "key",
      key: "key",
      width: 50,
      render: (text) => <strong>{text}</strong>,
    },
    {
      title: "Survey Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Start Date",
      dataIndex: "startDate",
      key: "startDate",
    },
    {
      title: "End Date",
      dataIndex: "endDate",
      key: "endDate",
    },
    {
      title: "Edit",
      dataIndex: "edit",
      key: "edit",
      width: 60,
      render: () => (
        <EditOutlined style={{ color: "#1890ff", cursor: "pointer" }} />
      ),
    },
    {
      title: "Delete",
      dataIndex: "delete",
      key: "delete",
      width: 70,
      render: () => (
        <DeleteOutlined style={{ color: "#ff4d4f", cursor: "pointer" }} />
      ),
    },
    {
      title: "Assign",
      dataIndex: "assign",
      key: "assign",
      width: 70,
      render: () => (
        <Button type="primary" icon={<UserAddOutlined />} size="small"></Button>
      ),
    },
  ];

  return (
    <main id="main" className="main">
      <div style={{ padding: "20px" }}>
        {/* <Button
        type="primary"
        icon={<LikeOutlined />}
        onClick={() => setOpen(true)}
        style={{ marginBottom: "20px" }}
      >
        Open Survey Form
      </Button>
      <Drawer
        title="Survey"
        placement="right"
        onClose={() => setOpen(false)}
        open={open}
        width={400}
      >
        <CustomGoogleForms setOpen={setOpen} />
      </Drawer> */}
        <div
          style={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            marginBottom: "20px",
          }}
        >
          <h3>Survey List</h3>
          <Button
            type="primary"
            icon={<PlusOutlined />}
            onClick={redirectToCreateForm}
          >
            Create
          </Button>
        </div>
        <Table dataSource={dataSource} columns={columns} />
      </div>
    </main>
  );
};

export default SurveyForm;
