<?php

namespace App\Form;

use App\Entity\Evenement;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class EvenementType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('date')
            ->add('nomEvent')
            ->add('description')
            ->add('capaciteEvent')
            ->add('nbMax')
            ->add('imageEvent')
            ->add('locationEvent')
            ->add('ratingEvent')
            ->add('categorie')
            ->add('typeEvent')
            ->add('idOrg')
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Evenement::class,
        ]);
    }
}
