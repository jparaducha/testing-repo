package carinaAutomationHomework.carina.demo.db.mappers;

import carinaAutomationHomework.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);

}
