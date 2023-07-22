package net.AhmedAli.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.AhmedAli.organizationservice.dto.OrganizationDto;
import net.AhmedAli.organizationservice.entity.Organization;
import net.AhmedAli.organizationservice.mapper.OrganizationMapper;
import net.AhmedAli.organizationservice.repository.OrganizationRepository;
import net.AhmedAli.organizationservice.service.OrganizationService;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
