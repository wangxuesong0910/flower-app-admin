import request from '@/utils/request'

// 查询鲜花的科属(一级分类)列表
export function listAscription(query) {
  return request({
    url: '/erp/ascription/list',
    method: 'get',
    params: query
  })
}

// 查询鲜花的科属(一级分类)详细
export function getAscription(id) {
  return request({
    url: '/erp/ascription/' + id,
    method: 'get'
  })
}

// 新增鲜花的科属(一级分类)
export function addAscription(data) {
  return request({
    url: '/erp/ascription',
    method: 'post',
    data: data
  })
}

// 修改鲜花的科属(一级分类)
export function updateAscription(data) {
  return request({
    url: '/erp/ascription',
    method: 'put',
    data: data
  })
}

// 删除鲜花的科属(一级分类)
export function delAscription(id) {
  return request({
    url: '/erp/ascription/' + id,
    method: 'delete'
  })
}
