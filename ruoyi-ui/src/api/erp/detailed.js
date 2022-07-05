import request from '@/utils/request'

// 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
export function listDetailed(query) {
  return request({
    url: '/erp/detailed/list',
    method: 'get',
    params: query
  })
}

// 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)详细
export function getDetailed(id) {
  return request({
    url: '/erp/detailed/' + id,
    method: 'get'
  })
}

// 新增花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
export function addDetailed(data) {
  return request({
    url: '/erp/detailed',
    method: 'post',
    data: data
  })
}

// 修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
export function updateDetailed(data) {
  return request({
    url: '/erp/detailed',
    method: 'put',
    data: data
  })
}

// 删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)
export function delDetailed(id) {
  return request({
    url: '/erp/detailed/' + id,
    method: 'delete'
  })
}

// 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表
export function listDetailedBo(query) {
  return request({
    url: '/erp/detailed/listBo',
    method: 'get',
    params: query
  })
}
