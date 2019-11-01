package ua.balash.hearthstone.character;

public interface Character
{
	int getHealth();

	int getMaxHealth();

	int getInitialHealth();

	int getAttack();

	int getInitialAttack();

	void dealDamage(int damage);

	void destroy();
}
