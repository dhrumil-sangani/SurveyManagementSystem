import React from 'react'
import Table from 'react-bootstrap/Table';
import BootstrapTable from "react-bootstrap-table-next";
import ToolkitProvider, {Search} from 'react-bootstrap-table2-toolkit/dist/react-bootstrap-table2-toolkit';

const TableComponent = (props) => {

  const rowData = props?.rowData;
  const columns = props?.columns;
  const type = props?.type;
  const keyField = props?.keyField;

  const { SearchBar } = Search;

  const ClearButton = (props) => {
  }

  const rowClasses = (row,rowIndex) => {
  }

  return (
    <ToolkitProvider
        bootstrap4
        keyField={keyField?keyField:"id"}
        data={rowData}
        columns={columns}
        search
    >
      {(props) => (
          <div className='my-table-wraper'>
              <div className='my-table'>
                  <SearchBar
                      srText = ""
                      {...props.searchProps}
                  />
              </div>
              <ClearButton
                  {...props.searchProps}
                  // clearAllFilter={clearAllFilter}
              /> 
              <div className='table-responsive common-table'>
                  <BootstrapTable
                  {...props.baseProps}
                  noDataIndication="No record found"
                  // striped
                  rowClasses={rowClasses}
                  hover
                  condensed
                  />
              </div>
          </div>
      )}
    </ToolkitProvider>
  )
}

export default TableComponent