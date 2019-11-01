package ua.balash.hearthstone.character;

public abstract class AbstractCharacter implements Character
{
	private final int initialHealth;
	private final int initialAttack;

	private int maxHealth;
	private int currentHealth;
	private int currentAttack;

	public AbstractCharacter(final int initialHealth, final int initialAttack)
	{
		this.initialHealth = initialHealth;
		this.maxHealth = initialHealth;
		this.currentHealth = initialHealth;
		this.initialAttack = initialAttack;
		this.currentAttack = initialAttack;
	}

	public int getHealth()
	{
		return currentHealth;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public int getInitialHealth()
	{
		return initialHealth;
	}

	public int getAttack()
	{
		return currentAttack;
	}

	public int getInitialAttack()
	{
		return initialAttack;
	}

	public void dealDamage(final int damage)
	{
		currentHealth -= damage;
		if (currentHealth <= 0)
		{
			destroy();
		}
	}
}
