import { useCallback } from 'react';
import { Button, Form, Input, Radio, Space, notification } from 'antd';

const CustomGoogleForms = ({ setOpen }) => {
  const [form] = Form.useForm();
  const [api, contextHolder] = notification.useNotification();

  const onFinish = useCallback(
    async ({ email, version, duration }) => {
      try {
        await fetch(
          'https://docs.google.com/forms/d/e/1FAIpQLSeZr6hSDJXdfbnNQ2omeMYLd0SpLwABU3BYUK0mpEzuILdcBQ/formResponse?' +
            new URLSearchParams({
              'entry.2057655542': version,
              'entry.1743450499': duration ?? '',
              emailAddress: email,
            }),
          {
            mode: 'no-cors',
          }
        );
        api.success({
          message: 'Submitted successfully',
        });
        form.resetFields();
        setOpen(false);
      } catch (e) {
        api.error({
          message: e.message,
        });
      }
    },
    [api, form]
  );

  return (
    <>
      {contextHolder}
      <Form
        form={form}
        layout="vertical"
        wrapperCol={{ span: 18 }}
        onFinish={onFinish}
      >
        <Form.Item
          name="email"
          label="Email"
          rules={[{ required: true, message: 'Email address is required' }]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          name="version"
          label="1. Which version of React are you using?"
          rules={[{ required: true, message: 'React version is required' }]}
        >
          <Radio.Group>
            <Space direction="vertical">
              <Radio value="React 16">React 16</Radio>
              <Radio value="React 17">React 17</Radio>
              <Radio value="React 18">React 18</Radio>
            </Space>
          </Radio.Group>
        </Form.Item>
        <Form.Item
          name="duration"
          label="2. How long have you been using React version from Question 1?"
        >
          <Input />
        </Form.Item>
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
      </Form>
    </>
  );
};

export default CustomGoogleForms;