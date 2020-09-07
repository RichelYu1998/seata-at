package cn.tedu.service;

public interface StorageService {
    void decrease(Long productId, Integer count) throws Exception;
}
