<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210409164028 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY FK_E33BD3B816912862');
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY FK_E33BD3B8A76ED395');
        $this->addSql('DROP INDEX fk_e33bd3b8a76ed395 ON candidature');
        $this->addSql('CREATE INDEX fk_userrrr ON candidature (user_id)');
        $this->addSql('DROP INDEX fk_e33bd3b816912862 ON candidature');
        $this->addSql('CREATE INDEX fk_annnnn ON candidature (ann_id)');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT FK_E33BD3B816912862 FOREIGN KEY (ann_id) REFERENCES annonce (id_ann)');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT FK_E33BD3B8A76ED395 FOREIGN KEY (user_id) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY FK_538B74BD6B3CA4B');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY FK_538B74BDD1AA708F');
        $this->addSql('DROP INDEX fk_538b74bdd1aa708f ON interactions');
        $this->addSql('CREATE INDEX fk_uppppp ON interactions (id_post)');
        $this->addSql('DROP INDEX fk_538b74bd6b3ca4b ON interactions');
        $this->addSql('CREATE INDEX fk_ussssss ON interactions (id_user)');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT FK_538B74BD6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT FK_538B74BDD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY FK_1BD243CD6B3CA4B');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY FK_1BD243CDD1AA708F');
        $this->addSql('DROP INDEX fk_1bd243cdd1aa708f ON signalisation');
        $this->addSql('CREATE INDEX fkkk ON signalisation (id_post)');
        $this->addSql('DROP INDEX fk_1bd243cd6b3ca4b ON signalisation');
        $this->addSql('CREATE INDEX fuuaz ON signalisation (id_user)');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT FK_1BD243CD6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT FK_1BD243CDD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE type_event CHANGE type_name type_name VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY FK_E33BD3B816912862');
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY FK_E33BD3B8A76ED395');
        $this->addSql('DROP INDEX fk_annnnn ON candidature');
        $this->addSql('CREATE INDEX FK_E33BD3B816912862 ON candidature (ann_id)');
        $this->addSql('DROP INDEX fk_userrrr ON candidature');
        $this->addSql('CREATE INDEX FK_E33BD3B8A76ED395 ON candidature (user_id)');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT FK_E33BD3B816912862 FOREIGN KEY (ann_id) REFERENCES annonce (id_ann)');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT FK_E33BD3B8A76ED395 FOREIGN KEY (user_id) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY FK_538B74BDD1AA708F');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY FK_538B74BD6B3CA4B');
        $this->addSql('DROP INDEX fk_uppppp ON interactions');
        $this->addSql('CREATE INDEX FK_538B74BDD1AA708F ON interactions (id_post)');
        $this->addSql('DROP INDEX fk_ussssss ON interactions');
        $this->addSql('CREATE INDEX FK_538B74BD6B3CA4B ON interactions (id_user)');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT FK_538B74BDD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT FK_538B74BD6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY FK_1BD243CDD1AA708F');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY FK_1BD243CD6B3CA4B');
        $this->addSql('DROP INDEX fkkk ON signalisation');
        $this->addSql('CREATE INDEX FK_1BD243CDD1AA708F ON signalisation (id_post)');
        $this->addSql('DROP INDEX fuuaz ON signalisation');
        $this->addSql('CREATE INDEX FK_1BD243CD6B3CA4B ON signalisation (id_user)');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT FK_1BD243CDD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT FK_1BD243CD6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE type_event CHANGE type_name type_name VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`');
    }
}
