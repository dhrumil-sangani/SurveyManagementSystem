import React from 'react'
import BootstrapTable from "react-bootstrap-table-next";
import ToolkitProvider, {Search} from 'react-bootstrap-table2-toolkit/dist/react-bootstrap-table2-toolkit';
import paginationFactory from "react-bootstrap-table2-paginator";

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

    const pagination = paginationFactory({
        page: 1,
        sizePerPage: 10,
        lastPageText: ">>",
        firstPageText: "<<",
        nextPageText: ">",
        prePageText: "<",
        showTotal: true,
        alwaysShowAllBtns: true,
        onPageChange: function (page, sizePerPage) {
            // console.log("page", page);
            // console.log("sizePerPage", sizePerPage);
        },
        onSizePerPageChange: function (page, sizePerPage) {
            // console.log("page", page);
            // console.log("sizePerPage", sizePerPage);
        }
    });

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
              <div className='common-table'>
                  <BootstrapTable
                        {...props.baseProps}
                        noDataIndication="No record found"
                        // striped
                        rowClasses={rowClasses}
                        hover
                        condensed
                        pagination={pagination}
                  />
              </div>
          </div>
      )}
    </ToolkitProvider>
  )
}

export default TableComponent