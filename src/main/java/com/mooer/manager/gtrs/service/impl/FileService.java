package com.mooer.manager.gtrs.service.impl;

import com.mooer.manager.gtrs.pojo.File;
import com.mooer.manager.gtrs.mapper.FileMapper;
import com.mooer.manager.gtrs.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author main
 * @since 2022-07-29
 */
@Service
public class FileService extends ServiceImpl<FileMapper, File> implements IFileService {

}
