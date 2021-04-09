<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20210409150002 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE annonce DROP FOREIGN KEY annonce_ibfk_1');
        $this->addSql('ALTER TABLE annonce CHANGE categorie categorie VARCHAR(255) DEFAULT NULL');
        $this->addSql('ALTER TABLE annonce ADD CONSTRAINT FK_F65593E5497DD634 FOREIGN KEY (categorie) REFERENCES categorie (categorie_name)');
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY fk_annnnn');
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY fk_userrrr');
        $this->addSql('ALTER TABLE candidature CHANGE user_id user_id INT DEFAULT NULL, CHANGE ann_id ann_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT FK_E33BD3B816912862 FOREIGN KEY (ann_id) REFERENCES annonce (id_ann)');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT FK_E33BD3B8A76ED395 FOREIGN KEY (user_id) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE categorie CHANGE categorie_name categorie_name VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE comment_event DROP FOREIGN KEY eventt');
        $this->addSql('ALTER TABLE comment_event DROP FOREIGN KEY userr');
        $this->addSql('ALTER TABLE comment_event CHANGE id_user id_user INT DEFAULT NULL, CHANGE id_event id_event INT DEFAULT NULL');
        $this->addSql('ALTER TABLE comment_event ADD CONSTRAINT FK_92349256D52B4B97 FOREIGN KEY (id_event) REFERENCES evenement (id)');
        $this->addSql('ALTER TABLE comment_event ADD CONSTRAINT FK_923492566B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE comments DROP FOREIGN KEY id_post2');
        $this->addSql('ALTER TABLE comments DROP FOREIGN KEY id_use2');
        $this->addSql('ALTER TABLE comments CHANGE id_post id_post INT DEFAULT NULL, CHANGE id_user id_user INT DEFAULT NULL');
        $this->addSql('ALTER TABLE comments ADD CONSTRAINT FK_5F9E962AD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE comments ADD CONSTRAINT FK_5F9E962A6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY evenement_ibfk_1');
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY fk_org');
        $this->addSql('ALTER TABLE evenement CHANGE id_org id_org INT DEFAULT NULL, CHANGE type_event type_event VARCHAR(255) DEFAULT NULL, CHANGE categorie categorie VARCHAR(255) DEFAULT NULL, CHANGE nb_max nb_max INT NOT NULL, CHANGE rating_event rating_event INT DEFAULT NULL');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT FK_B26681E497DD634 FOREIGN KEY (categorie) REFERENCES categorie (categorie_name)');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT FK_B26681EECB152DA FOREIGN KEY (id_org) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE feedback CHANGE id_user id_user INT DEFAULT NULL');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY fk_uppppp');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY fk_ussssss');
        $this->addSql('ALTER TABLE interactions CHANGE id_post id_post INT DEFAULT NULL, CHANGE id_user id_user INT DEFAULT NULL');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT FK_538B74BDD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT FK_538B74BD6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE partenaire DROP FOREIGN KEY fk_useerr');
        $this->addSql('ALTER TABLE partenaire CHANGE id_user id_user INT DEFAULT NULL');
        $this->addSql('ALTER TABLE partenaire ADD CONSTRAINT FK_32FFA3736B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE participant CHANGE id_user id_user INT DEFAULT NULL, CHANGE id_event id_event INT DEFAULT NULL');
        $this->addSql('ALTER TABLE postes DROP FOREIGN KEY catttttt');
        $this->addSql('ALTER TABLE postes DROP FOREIGN KEY ctn1');
        $this->addSql('ALTER TABLE postes DROP FOREIGN KEY postes_ibfk_1');
        $this->addSql('ALTER TABLE postes CHANGE categorie categorie VARCHAR(255) DEFAULT NULL, CHANGE id_user id_user INT DEFAULT NULL, CHANGE Likes Likes INT NOT NULL');
        $this->addSql('ALTER TABLE postes ADD CONSTRAINT FK_5A763C64497DD634 FOREIGN KEY (categorie) REFERENCES categorie (categorie_name)');
        $this->addSql('ALTER TABLE postes ADD CONSTRAINT FK_5A763C646B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE rating_event CHANGE id_user id_user INT DEFAULT NULL, CHANGE id_event id_event INT DEFAULT NULL');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY fkkk');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY fuuaz');
        $this->addSql('ALTER TABLE signalisation CHANGE id_user id_user INT DEFAULT NULL, CHANGE id_post id_post INT DEFAULT NULL');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT FK_1BD243CDD1AA708F FOREIGN KEY (id_post) REFERENCES postes (id_post)');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT FK_1BD243CD6B3CA4B FOREIGN KEY (id_user) REFERENCES user (id_user)');
        $this->addSql('ALTER TABLE type_event CHANGE type_name type_name VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE annonce DROP FOREIGN KEY FK_F65593E5497DD634');
        $this->addSql('ALTER TABLE annonce CHANGE categorie categorie VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`');
        $this->addSql('ALTER TABLE annonce ADD CONSTRAINT annonce_ibfk_1 FOREIGN KEY (categorie) REFERENCES categorie (categorie_name) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY FK_E33BD3B816912862');
        $this->addSql('ALTER TABLE candidature DROP FOREIGN KEY FK_E33BD3B8A76ED395');
        $this->addSql('ALTER TABLE candidature CHANGE ann_id ann_id INT NOT NULL, CHANGE user_id user_id INT NOT NULL');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT fk_annnnn FOREIGN KEY (ann_id) REFERENCES annonce (id_ann) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE candidature ADD CONSTRAINT fk_userrrr FOREIGN KEY (user_id) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE categorie CHANGE categorie_name categorie_name VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`');
        $this->addSql('ALTER TABLE comment_event DROP FOREIGN KEY FK_92349256D52B4B97');
        $this->addSql('ALTER TABLE comment_event DROP FOREIGN KEY FK_923492566B3CA4B');
        $this->addSql('ALTER TABLE comment_event CHANGE id_event id_event INT NOT NULL, CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE comment_event ADD CONSTRAINT eventt FOREIGN KEY (id_event) REFERENCES evenement (id) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE comment_event ADD CONSTRAINT userr FOREIGN KEY (id_user) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE comments DROP FOREIGN KEY FK_5F9E962AD1AA708F');
        $this->addSql('ALTER TABLE comments DROP FOREIGN KEY FK_5F9E962A6B3CA4B');
        $this->addSql('ALTER TABLE comments CHANGE id_post id_post INT NOT NULL, CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE comments ADD CONSTRAINT id_post2 FOREIGN KEY (id_post) REFERENCES postes (id_post) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE comments ADD CONSTRAINT id_use2 FOREIGN KEY (id_user) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY FK_B26681E497DD634');
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY FK_B26681EECB152DA');
        $this->addSql('ALTER TABLE evenement CHANGE categorie categorie VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, CHANGE type_event type_event VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, CHANGE id_org id_org INT NOT NULL, CHANGE nb_max nb_max INT DEFAULT 0 NOT NULL, CHANGE rating_event rating_event INT DEFAULT 0');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT evenement_ibfk_1 FOREIGN KEY (categorie) REFERENCES categorie (categorie_name) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT fk_org FOREIGN KEY (id_org) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE feedback CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY FK_538B74BDD1AA708F');
        $this->addSql('ALTER TABLE interactions DROP FOREIGN KEY FK_538B74BD6B3CA4B');
        $this->addSql('ALTER TABLE interactions CHANGE id_post id_post INT NOT NULL, CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT fk_uppppp FOREIGN KEY (id_post) REFERENCES postes (id_post) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE interactions ADD CONSTRAINT fk_ussssss FOREIGN KEY (id_user) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE partenaire DROP FOREIGN KEY FK_32FFA3736B3CA4B');
        $this->addSql('ALTER TABLE partenaire CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE partenaire ADD CONSTRAINT fk_useerr FOREIGN KEY (id_user) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE participant CHANGE id_event id_event INT NOT NULL, CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE postes DROP FOREIGN KEY FK_5A763C64497DD634');
        $this->addSql('ALTER TABLE postes DROP FOREIGN KEY FK_5A763C646B3CA4B');
        $this->addSql('ALTER TABLE postes CHANGE categorie categorie VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, CHANGE id_user id_user INT NOT NULL, CHANGE Likes Likes INT DEFAULT 0 NOT NULL');
        $this->addSql('ALTER TABLE postes ADD CONSTRAINT catttttt FOREIGN KEY (categorie) REFERENCES categorie (categorie_name) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE postes ADD CONSTRAINT ctn1 FOREIGN KEY (id_user) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE postes ADD CONSTRAINT postes_ibfk_1 FOREIGN KEY (id_post) REFERENCES interactions (id_post) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE rating_event CHANGE id_event id_event INT NOT NULL, CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY FK_1BD243CDD1AA708F');
        $this->addSql('ALTER TABLE signalisation DROP FOREIGN KEY FK_1BD243CD6B3CA4B');
        $this->addSql('ALTER TABLE signalisation CHANGE id_post id_post INT NOT NULL, CHANGE id_user id_user INT NOT NULL');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT fkkk FOREIGN KEY (id_post) REFERENCES postes (id_post) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE signalisation ADD CONSTRAINT fuuaz FOREIGN KEY (id_user) REFERENCES user (id_user) ON UPDATE CASCADE ON DELETE CASCADE');
        $this->addSql('ALTER TABLE type_event CHANGE type_name type_name VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`');
    }
}
