package org.example.solidprinciples.stateDesignPattern.DesignVendingMachineImproved;

public class ProductNameGenerator {
    // Array of snack product names
    static String[] snackNames = {
            "Cheddar Cheese Crackers", "Sea Salt Pretzels", "Honey Roasted Peanuts", "Fruit & Nut Mix", "Cinnamon Almonds",
            "Jalapeño Chips", "Salted Popcorn", "BBQ Potato Chips", "Mixed Berry Granola Bar", "Dark Chocolate Almonds",
            "Pita Chips", "Sweet & Spicy Trail Mix", "Toasted Coconut Chips", "Peanut Butter Cups", "Maple Pecan Clusters",
            "White Cheddar Popcorn", "Caramel Popcorn", "Ranch Corn Nuts", "Honey Mustard Pretzels", "Apple Cinnamon Chips",
            "Sesame Sticks", "Teriyaki Beef Jerky", "Cheddar Popcorn", "Garlic Parmesan Pretzels", "Peanut Butter Granola Bar",
            "Spicy Wasabi Peas", "Chocolate Hazelnut Spread", "Salt & Vinegar Chips", "Pumpkin Seed Clusters", "Honey Almond Bar",
            "Sweet Potato Chips", "Roasted Seaweed Snacks", "Protein Power Bar", "Blueberry Yogurt Pretzels", "Mini Rice Cakes",
            "Chocolate Covered Pretzels", "Buffalo Ranch Nuts", "Coconut Cashew Crunch", "Lemon Poppy Seed Cookies", "Crispy Banana Chips",
            "Roasted Chickpeas", "Dried Mango Slices", "Greek Yogurt Trail Mix", "Apple Cinnamon Nut Bar", "Maple Honey Clusters",
            "Spicy Cheese Puffs", "Garlic Herb Crackers", "Salted Almond Clusters", "Dark Chocolate Covered Cherries", "Green Tea Matcha Cookies"
    };

    // Array of snack product descriptions
    static String[] snackDescriptions = {
            "Crunchy cheddar-flavored crackers, perfect for cheese lovers.",
            "Crispy pretzels lightly dusted with sea salt for a classic taste.",
            "Sweet and salty peanuts roasted with a touch of honey.",
            "A mix of dried fruits and nuts, a perfect balance of sweet and savory.",
            "Almonds coated with a delicious cinnamon glaze for a sweet crunch.",
            "Crispy chips with a spicy kick of jalapeño flavor.",
            "Light and airy popcorn with just the right amount of salt.",
            "Crunchy potato chips coated in a savory BBQ flavor.",
            "Chewy granola bar packed with mixed berries and oats.",
            "Roasted almonds covered in rich dark chocolate.",
            "Crispy pita chips, perfect for dipping or eating alone.",
            "Trail mix with a mix of sweet and spicy flavors in every bite.",
            "Thin, crispy chips made from toasted coconut for a tropical taste.",
            "Classic peanut butter cups for a perfect chocolatey treat.",
            "Clusters of pecans and oats with a touch of maple syrup.",
            "Fluffy popcorn with a white cheddar coating.",
            "Sweet caramel-coated popcorn for a delicious snack.",
            "Crunchy corn nuts coated in a savory ranch flavor.",
            "Crispy pretzels with a honey mustard glaze for a tangy taste.",
            "Dried apple chips with a hint of cinnamon for a sweet crunch.",
            "Crunchy sesame sticks with a savory, nutty flavor.",
            "Beef jerky flavored with a sweet and savory teriyaki glaze.",
            "Popcorn coated in a bold cheddar cheese flavor.",
            "Pretzels with a garlic and parmesan cheese twist.",
            "A chewy granola bar with creamy peanut butter.",
            "Crispy green peas with a spicy wasabi coating.",
            "Smooth hazelnut spread with rich chocolate flavor.",
            "Crunchy potato chips with a tangy salt and vinegar flavor.",
            "Clusters of pumpkin seeds with a touch of sweetness.",
            "A nutty bar with almonds and a hint of honey.",
            "Crispy chips made from sweet potatoes for a healthier snack.",
            "Roasted seaweed for a light, savory snack with a hint of salt.",
            "High-protein bar for a satisfying energy boost.",
            "Pretzels covered in sweet blueberry yogurt coating.",
            "Mini rice cakes with a light, crispy texture.",
            "Pretzels dipped in rich chocolate for a sweet and salty snack.",
            "Nuts coated in a bold buffalo ranch seasoning.",
            "Crunchy cashew pieces with a light coconut glaze.",
            "Soft lemon cookies with a sprinkle of poppy seeds.",
            "Crispy, sweet banana chips for a satisfying snack.",
            "Roasted chickpeas for a crunchy, high-protein snack.",
            "Slices of dried mango for a sweet, chewy treat.",
            "Trail mix with Greek yogurt-covered nuts and dried fruits.",
            "Nut bar with apples and a touch of cinnamon.",
            "Clusters of oats and nuts with maple and honey.",
            "Puffy cheese snacks with a spicy kick.",
            "Savory crackers flavored with garlic and herbs.",
            "Clusters of almonds with a light salt coating.",
            "Tart cherries dipped in smooth dark chocolate.",
            "Soft, delicate cookies with green tea matcha flavor."
    };

    // Array of snack product prices
    static int[] snackPrices = {
            150, 120, 100, 180, 200,
            130, 90, 140, 110, 220,
            160, 190, 170, 250, 210,
            100, 130, 90, 120, 140,
            180, 300, 140, 125, 110,
            150, 200, 130, 175, 145,
            125, 105, 220, 115, 90,
            210, 160, 180, 135, 95,
            170, 160, 190, 145, 155,
            230, 150, 215, 240, 175
    };
    static int index = 0;
    public static Item getRandomProductDetail()
    {
        Item randomProductItem = new Item();
        randomProductItem.setName(snackNames[index]);
        randomProductItem.setDescription(snackDescriptions[index]);
        randomProductItem.setPrice(snackPrices[index]);
        index++;
        return randomProductItem;
    }
}