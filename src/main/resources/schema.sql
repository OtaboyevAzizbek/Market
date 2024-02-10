CREATE FUNCTION updateProductAmount()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$$
BEGIN
    UPDATE products p SET total_amount=total_amount+new.product_amount WHERE p.product_id=new.product_id;
    RETURN NEW;
END
$$;
CREATE TRIGGER updateProduct AFTER
    INSERT ON invoice_document_items
    FOR EACH ROW EXECUTE
    PROCEDURE updateProductAmount();