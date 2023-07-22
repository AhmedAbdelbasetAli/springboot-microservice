package net.AhmedAli.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.AhmedAli.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
